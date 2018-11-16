export default {
  data() {
      return {
        userPassword: '',
        userAccount: ''
    };
  },
  methods: {
    login(){
      this.$axios.post('/api/user/login/login.do',{userAccount:this.userAccount,userPassword:this.userPassword}).then(res =>{
        this.$router.push({path:'/home'})
      },error =>{
        this.$message('这是一条消息提示');
      })

    }
  }
}
