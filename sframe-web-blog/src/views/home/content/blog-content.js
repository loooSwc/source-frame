export default {
  components: {
  },
  mounted () {
    this.loading = true
    // this.blog.id = this.$route.params.id
    // console.log(this.$route.params.id)

    this.blog['title'] = '2018.5.22 更新'
    this.blog['content'] = this.$markdown("---\n" +
      "title: zookeeper选举机制\n" +
      "date: 2017-12-13 15:38:02\n" +
      "tags:\n" +
      "  - Zookeeper\n" +
      "---\n" +
      "## zookeeper运行模式\n" +
      "ZooKeeper服务有两种不同的运行模式。一种是\"独立模式\"(standalone mode)，即只有一个ZooKeeper服务器。这种模式较为简单，比较适合于测试环境，甚至可以在单元测试中采用，但是不能保证高可用性和恢复性。在生产环境中的ZooKeeper通常以\"复制模式\"(replicated mode)运行于一个计算机集群上，这个计算机集群被称为一个\"集合体\"(ensemble)。\n" +
      "![](https://i.imgur.com/mgpMdoe.png)\n" +
      "ZooKeeper通过复制来实现高可用性，只要集合体中半数以上的机器处于可用状态，它就能够提供服务。例如，在一个有5个节点的集合体中，每个Follower节点的数据都是Leader节点数据的副本，也就是说我们的每个节点的数据视图都是一样的，这样就可以有五个节点提供ZooKeeper服务。并且集合体中任意2台机器出现故障，都可以保证服务继续，因为剩下的3台机器超过了半数。\n" +
      " **注意，6个节点的集合体也只能够容忍2台机器出现故障，因为如果3台机器出现故障，剩下的3台机器没有超过集合体的半数。出于这个原因，一个集合体通常包含奇数台机器。**\n" +
      "\n" +
      "从概念上来说，ZooKeeper它所做的就是确保对Znode树的每一个修改都会被复制到集合体中超过半数的机器上。如果少于半数的机器出现故障，则最少有一台机器会保存最新的状态，那么这台机器就是我们的Leader。其余的副本最终也会更新到这个状态。如果Leader挂了，由于其他机器保存了Leader的副本，那就可以从中选出一台机器作为新的Leader继续提供服务。\n" +
      "那么,zookeeper的leader选举的机制是什么呢?我们在此研究下\n" +
      "\n" +
      "## 选择机制中的概念\n" +
      "### 服务器ID\n" +
      "比如有三台服务器，编号分别是1,2,3。编号越大代表该服务器成为Leader的权重越大。\n" +
      "这里的编号就是`zookeeperdata/myid`的值\n" +
      "### 数据ID\n" +
      "即ZXID,ZXID越大,代表该zookeeper机器中的数据越新,同时代表该服务器成为Leader的权重越大\n" +
      "### 逻辑时钟\n" +
      "或者叫投票的次数，同一轮投票过程中的逻辑时钟值是相同的。每投完一次票这个数据就会增加，然后与接收到的其它服务器返回的投票信息中的数值相比，根据不同的值做出不同的判断(更新自己的投票结果或者无视返回结果)。\n" +
      "### 选举状态\n" +
      "* LOOKING，竞选状态。\n" +
      "* FOLLOWING，随从状态，同步leader状态，参与投票。\n" +
      "* OBSERVING，观察状态,同步leader状态，不参与投票。\n" +
      "* LEADING，领导者状态。\n" +
      "\n" +
      "## zookeeper选举算法\n" +
      "zookeeper提供了三种方式：\n" +
      "* LeaderElection\n" +
      "* AuthFastLeaderElection\n" +
      "* FastLeaderElection\n" +
      "\n" +
      "如何在zookeeper集群中选举出一个leader,zookeeper使用了三种算法,具体使用哪种算法,在配置文件中是可以配置的,对应的配置项是”electionAlg”,其中1对应的是LeaderElection算法,2对应的是AuthFastLeaderElection算法,3对应的是FastLeaderElection算法.默认使用FastLeaderElection算法\n" +
      "## 什么情况会出现选举Leader\n" +
      "Leader选举是保证分布式数据一致性的关键所在。当Zookeeper集群中的一台服务器出现以下两种情况之一时，需要进入Leader选举。\n" +
      "* 服务器初始化启动。\n" +
      "* 服务器运行期间无法和Leader保持连接。\n" +
      "\n" +
      "### 服务器启动时期的Leader选举\n" +
      "假设我们拥有五台zookeeper机器,分别为1,2,3,4,5,启动顺序依次排列,他们的myid分别为1,2,3,4,5,由于是服务器初始化启动,原始数据皆为空,所以ZXID都为0;\n" +
      "此时,先启动机器1,机器1首先投票给自己,选举自己为Leader,记为[1,0],此时接收其他机器的投票(无);\n" +
      "启动机器2,首先投票给自己,选举自己为Leader,记为[2,0],此时接收到其他机器(机器1)的投票([1,0]),与自己的投票进行对比,发现ZXID都一样,都是0,则去对比myid大小,发现机器2的myid大,则机器2的投票不变,通知机器1更改投票结果,此时机器1,2投票都为[2,0],但由于并没有超过半数的机器支持机器2为Leader,所以机器1,2的状态仍为LOOKING;\n" +
      "启动机器3,首先投票给自己,选举自己为Leader,记为[3,0],此时接收到其他机器(机器1,2)的投票([(2,0),(2,0)]),与自己的投票进行对比,发现ZXID都一样,都是0,则去对比myid大小,发现机器3的myid大,则机器3的投票不变,通知机器1,机器2更改投票结果,此时机器1,2投票更改为[3,0],此时超过了半数机器支持机器3作为Leader,此时选举结束,机器3成为Leader,机器1,2作为Follower;\n" +
      "启动机器4,首先投票给自己,选举自己为Leader,记为[4,0],此时接收到其他机器(机器1,2,3)的投票([(3,0),(3,0),(3,0)]),与自己的投票进行对比,发现ZXID都一样,都是0,则去对比myid大小,尽管发现机器4的myid大,但是因为第三部时已经选举出来机器3作为Leader,所以机器4只能作为Follower;\n" +
      "启动机器5,结果同机器4\n" +
      "\n" +
      "### 服务器运行时期的Leader选举\n" +
      "在集群运行期间,有可能会发生新的节点加入或者Leader宕机的情况,如果是新节点加入,不会影响到Leader的更替(参见上面启动机器4,5的情况),但如果是Leader机器宕机,则需要重新选举Leader;\n" +
      "当发现Leader宕机,所有的非observer的机器状态都会变成LOOKING,同时首先投票给自己选举自己作为Leader,但此时有可能会出现不同机器的数据新旧不一致,大体步奏和服务器启动时期的Leader选举一致,唯一不同的是ZXID不同,需要选取ZXID最大的,也就是最新的作为Leader")
    this.blog['description'] = "1 增加其他站点的配置, 在状态栏显示个人的其他网站\n2 优化部分提示效果↵3 修复博客描述没有换行↵4 修改点击其他博客异常的bug↵5 修改日期格式↵6 修改使用帮助显示效果"
    this.blog['createTime'] = "2018-05-22 12:19:03"
    this.blog['updateTime'] = "2018-05-22 12:19:03"
        // console.log(JSON.stringify(this.blog))

    this.loading = false
  },
  data() {
    return {
      blog: {
        id: "",
        title: "",
        content: "",
        description: ""
      },
      loading: false,
    }
  },
  methods: {
    more() {
      this.$router.push('/home/list')
    }
  },
  // 如果还有别的组件，一定要移除掉 scroll的监听事件
  beforeDestroy() {

  },
}
