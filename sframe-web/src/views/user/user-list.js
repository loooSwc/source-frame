export default {
  data() {
    const item = {
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    };
    console.log(this.$route.path);
    return {
      tableData: Array(20).fill(item),
      currentPage1: 5,
      currentPage2: 5,
      currentPage3: 5,
      currentPage4: 4
    }
  },methods: {
    getUserPage(){
      this.$service.tablePage('/api/sys/user/list.do',{}).then();
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    }
  }, mounted: function () {
    this.getUserPage();
  }
};
