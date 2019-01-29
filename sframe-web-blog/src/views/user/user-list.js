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
          this.$message({
            showClose: true,
            message: '编辑用户信息成功',
            type: 'success'
          });
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
      this.$dialog({
          title: '修改密码',
          width: '500px'
        }, resolve =>
          require(['./edit-password/edit-password.vue'], resolve)
        , res => {
          this.$message({
            showClose: true,
            message: '修改密码成功',
            type: 'success'
          });
          this.getUserPage();
        }, error => {
          console.log('error', error)
        }, {
          'userId': _user.userId
        })
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
