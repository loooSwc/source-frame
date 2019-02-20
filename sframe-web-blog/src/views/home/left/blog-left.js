export default {
  components: {
  },
  mounted () {
    this.$nextTick(function() {
      window.addEventListener('scroll', this.onScroll);
    });
  },
  data() {
    return {
      active:'',
      postion:''
    }
  },
  methods: {
    onScroll() {
      let number = document.documentElement ? document.documentElement.scrollTop : document.body.scrollTop;
      console.log(number,document.documentElement.clientHeight,document.documentElement.scrollHeight);
      console.log();
      console.log();
      if (number >= 390) {
        this.postion = 'left-fixed';
      }else {
        this.postion = '';
      }
    }
  },
  // 如果还有别的组件，一定要移除掉 scroll的监听事件
  beforeDestroy() {
    window.removeEventListener('scroll', this.onScroll);
  },
}
