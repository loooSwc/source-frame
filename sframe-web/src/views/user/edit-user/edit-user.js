import '../service/user-service'
import userService from "../service/user-service";
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
      },
      rules: {
        userPhone: [
          {pattern: /^1[3|4|5|7|8][0-9]\d{8}$/, message: '请输入正确的手机号', trigger: ['change', 'blur']}
        ],
        userEmail: [
          {required: true, message: '请填写邮箱地址'},
          {type: 'email', message: '请输入正确的邮箱地址', trigger: ['change', 'blur']}
        ]
      }
    };
  },methods:{
    close(){
      this.$emit('close','close')
    },
    commit(){
      this.$refs['user'].validate((valid) => {
        if (valid) {
          userService.editUser(this.user).then(res => {
            this.$emit('commit',{});
          });
        }
      });
    },
    getUserDetail(){
      userService.getUserDetail(this.param.userId).then(res=>{
        this.user = res.data;
        },error => {
        console.log('err');
      });
    }
  }, mounted: function () {
    this.getUserDetail();
  }
};
