export default {
  data() {
    return {
      isCollapse: false,
      menuList: [],
      active: this.$route.path
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
    changeActive(_active) {
      console.log('111');
      this.active = _active;
    }
  }
}
;
