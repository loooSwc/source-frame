import userService from './service/user-service'
export default {
  data() {
    return {
      tableData: [],
      queryParams:{
        userEmail: ''
      }
    }
  }, methods: {
    getUserPage(currentPageNo = 1) {
      this.$service.tablePage('/api/sys/user/getUserPage.do', this.queryParams, currentPageNo).then(res => {
        this.tableData = res;
      });
    },
    editUser: function (item) {
      this.$dialog({
          title: '编辑用户',
          width: '500px'
        }, resolve =>
          require(['./edit-user/edit-user.vue'], resolve)
        , res => {
          this.getUserPage();
        }, error => {
          console.log('error', error)
        }, {
          'userId': item.userId
        })
    },
    addUser: function () {
      this.$dialog({
          title: '添加用户',
          width: '500px'
        }, resolve =>
          require(['./add-user/add-user.vue'], resolve)
        , res => {
          this.getUserPage();
        }, error => {
          console.log('error', error)
        }, {
        })
    },
    changeStatus: function (_status,_user) {
      _user.isEnable = _status;
      userService.changeStatus(_user).then(res => {
      },err => {
      });
    }
  }, mounted: function () {
    this.getUserPage();
  }
};
