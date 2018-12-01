import '../service/user-service'
import UserService from "../service/user-service";
export default {
  props: {
    param: {}
  },
  data() {
    return {
      user: {
        userId: '',
        userAccount: '',
        userName: '',
        isEnable: '',
        roleName: '',
        userPhone: '',
        userEmail: ''
      }
    };
  },methods:{
    close(){
      this.$emit('close','close')
    },
    commit(){
      this.$emit('commit','commit');
    },
    getUserDetail(){
      UserService.getUserDetail(this.param.userId).then(res=>{
        this.user = res.data;
        },error => {
        console.log('err');
      });
    }
  }, mounted: function () {
    this.getUserDetail();
  }
};
