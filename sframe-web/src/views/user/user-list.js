export default {
  data() {
    return {
      tableData: []
    }
  }, methods: {
    getUserPage(currentPageNo = 1) {
      this.$service.tablePage('/api/sys/user/getUserPage.do', {}, currentPageNo).then(res => {
        this.tableData = res;
      });
    },
    edit: function (item) {
      this.$dialog({
          title: '编辑用户',
          width: '500px'
        }, resolve =>
          require(['./edit-user/edit-user.vue'], resolve)
        , res => {
          console.log('ok', res);
        }, error => {
          console.log('error', error)
        }, {
          'userId': item.userId
        })
    }
  }, mounted: function () {
    this.getUserPage();
  }
};
