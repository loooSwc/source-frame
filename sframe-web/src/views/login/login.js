import {strEnc} from '../../assets/js/des'
export default {
  data() {
      return {
        userPassword: '',
        userAccount: ''
    };
  },
  methods: {
    login(){
      console.log();
      this.$axios.post('/api/user/login/getPassKey.do',{keyType: 'SESSION_PASSKEY'}).then(res => {
        let passKey = res.data;
        this.$axios.post('/api/user/login/login.do',{userAccount:this.userAccount,userPassword:strEnc(this.userPassword,passKey,'', '')}).then(res =>{
          this.$router.push({path:'/home'})
        },error =>{
          if(error.code == 200000){
            this.$message('这是一条消息提示');
          }
        })
      });
    }
  }
}
