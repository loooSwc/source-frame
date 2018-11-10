export default {
  data(){
    return {
      value: 'login.js'
    }
  },methods: {
    login(){
      this.$router.push({path:'/home'});
    }
  }
}
