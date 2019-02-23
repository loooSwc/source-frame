import userService from '../service/user-service'
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

    },
    addUser: function () {

    },
    changeStatus: function (_status,_user) {
      _user.isEnable = _status;
      userService.changeStatus(_user).then(res => {
      },err => {
      });
    },
    resetPassword: function (_user) {
      this.$confirm('确认要重置'+_user.userAccount+'的密码吗？', '', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        userService.resetPassword(_user.userId).then(res => {
          this.$alert('密码重置成功，新密码为'+res.data+'，请保存后登录修改密码', '', {
            confirmButtonText: '确定',
            callback: action => {

            }
          });
        });
      }).catch(() => {

      });
    },
    editPassword: function (_user) {

    },
    deleteUser: function (_user) {
      this.$confirm('确认要删除'+_user.userAccount+'用户吗？', '', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        userService.deleteUser(_user.userId).then(res => {
          this.$message({
            showClose: true,
            message: '删除用户'+_user.userAccount+'成功',
            type: 'success'
          });
          this.getUserPage();
        });
      }).catch(() => {

      });
    }
  }, mounted: function () {
    this.getUserPage();
  }
};
