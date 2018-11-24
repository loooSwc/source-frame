import EditUser from './edit-user/edit-user.vue'
export default {
  data() {
    return {
      tableData: [],
      isShowEditUser: false
    }
  },methods: {
    getUserPage(currentPageNo = 1){
      this.$service.tablePage('/api/sys/user/getUserPage.do',{},currentPageNo).then(res =>{
        this.tableData = res;
      });
    },
    edit: function (item) {
      this.isShowEditUser = true;
    }
  }, mounted: function () {
    this.getUserPage();
  },components: {
    'edit-user':EditUser
  }
};
