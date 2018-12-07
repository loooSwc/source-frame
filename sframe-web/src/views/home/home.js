import router from "../../router/router";

export default {
  data() {
    return {
      isCollapse: false,
      menuList: [],
      active: this.$route.path,
      userAccount: sessionStorage.getItem('userSessionAccount')
    }
  }, mounted: function () {
    this.getMenuList();
  },
  methods: {
    getMenuList() {
      this.$axios.post('/api/sys/menu/getMenuList.do').then(res => {
        this.menuList = res.data;
      })
    },
    handleCommand(command) {
      console.log('layout')
      sessionStorage.removeItem('userSessionAccount')
      router.push({path:'/login'});
    }
  }
}
;
