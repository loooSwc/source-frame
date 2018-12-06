import userService from "../service/user-service";
import roleService from '../../role/service/role-service'
import {strEnc} from "../../../assets/js/des";

export default {
  props: {
    param: {}
  },
  data() {
    var checkAccount = (rule, value, callback) => {
      if(value != '' && value.length > 0){
        let pattern = /^[a-zA-Z0-9_]{3,18}$/;
        let pa = new RegExp(pattern);
        if(pa.test(value)){
          userService.checkUserAccount(value).then(res => {
            if(res.data){
              callback(new Error('该账户已被占用'));
            }else {
              callback()
            }
          });
        }else {
          callback(new Error('请输入3-18位的账号名，仅支持字母和数字'));
        }
      }
    };
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
      password: '',
      checkPass:'',
      user: {
        userAccount: '',
        roleId: '',
        userPassword: '',
        firstPassword: '',
        secondPassword: '',
        userName: '',
        isEnable: '',
        roleName: '',
        userPhone: '',
        userEmail: ''
      },
      roleList:[],
      rules: {
        userAccount: [
          {required: true, message: '请填写用户账户'},
          {pattern: /^[a-zA-Z0-9_]{3,18}$/, message: '请输入3-18位的账号名，仅支持字母和数字', trigger: 'change'},
          {validator: checkAccount, trigger: 'blur'},
        ],
        firstPassword: [
          {required: true, message: '请填写登陆密码'},
          {validator: validateFirstPassword, trigger: ['change', 'blur']}
        ],
        secondPassword: [
          {required: true, message: '请填写确认密码'},
          {validator: validateSecondPassword, trigger: ['change', 'blur']}
        ],
        userPhone: [
          {pattern: /^1[3|4|5|7|8][0-9]\d{8}$/, message: '请输入正确的手机号', trigger: ['change', 'blur']}
        ],
        userEmail: [
          {required: true, message: '请填写邮箱地址'},
          {type: 'email', message: '请输入正确的邮箱地址', trigger: ['change', 'blur']}
        ],
        roleId: [
          {required: true, message: '请选择角色'}
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
          userService.getPassKey({keyType: 'SESSION_PASSKEY_REGISTER'}).then(res => {
            let passKey = res.data;
            this.user.userPassword = strEnc(this.user.firstPassword,passKey,'', '');
            userService.addUser(this.user).then(res => {
              this.$emit('commit','commit');
            });
          });
        }
      });

    },
    getRoleList(){
      roleService.getRoleList().then(res=>{
        this.roleList = res.data;
      },error => {
        console.log('err');
      });
    }
  }, mounted: function () {
    this.getRoleList();
  }
};
