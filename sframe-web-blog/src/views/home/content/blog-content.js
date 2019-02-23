export default {
  components: {
  },
  mounted () {
    this.loading = true
    // this.blog.id = this.$route.params.id
    // console.log(this.$route.params.id)

    this.blog['title'] = '2018.5.22 更新'
    this.blog['content'] = this.$markdown("* 张三")
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
