import userService from "../service/user-service";
import {strEnc} from "../../../assets/js/des";
export default {
  props: {
    param: {}
  },
  data(){
    var validateFirstPassword = (rule, value, callback) => {
      let pattern = /^(?!.*[\u4E00-\u9FA5\s]).{1,18}$/;
      let pa = new RegExp(pattern);
      if(pa.test(value)){
        if (this.user.secondPassword !== '') {
          this.$refs.user.validateField('secondPassword');
        }
        callback();
      }else {
        callback(new Error('请输入18位以下的密码，可以为字母、数字或特殊符号'));
      }
    };
    var validateSecondPassword = (rule, value, callback) => {
      let pattern = /^(?!.*[\u4E00-\u9FA5\s]).{1,18}$/;
      let pa = new RegExp(pattern);
      if(pa.test(value)){
        if(this.user.firstPassword != value){
          callback(new Error('两次输入密码不一致，请重新输入'));
        }else {
          callback();
        }
      }else {
        callback(new Error('请输入18位以下的密码，可以为字母、数字或特殊符号'));
      }
    };
    return {
      user: {
        userId: '',
        userPassword: '',
        firstPassword: '',
        secondPassword: '',
      },
      rules: {
        firstPassword: [
          {required: true, message: '请填写登陆密码'},
          {validator: validateFirstPassword, trigger: ['change', 'blur']}
        ],
        secondPassword: [
          {required: true, message: '请填写确认密码'},
          {validator: validateSecondPassword, trigger: ['change', 'blur']}
        ],
      }
    }
  },methods:{
    close(){
      this.$emit('close','close')
    },
    commit(){
      this.$refs['user'].validate((valid) => {
        if (valid) {
          userService.getPassKey({keyType: 'SESSION_PASSKEY_EDIT'}).then(res => {
            let passKey = res.data;
            this.user.userPassword = strEnc(this.user.firstPassword,passKey,'', '');
            this.user.userId = this.param.userId;
            userService.editPassword(this.user).then(res => {
              this.$emit('commit',{});
            });
          });
        }
      });

    }
  }
}
