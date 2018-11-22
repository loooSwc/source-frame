/**
 * http配置
 */
// 引入axios以及element ui中的loading和message组件
import axios from 'axios'
import { Loading, Message } from 'element-ui'
import router from '../router/router'
// 超时时间
axios.defaults.timeout = 50000
axios.defaults.headers = {
  "content-type": "application/json;charset=UTF-8"
}
// http请求拦截器
var loadinginstace
axios.interceptors.request.use(config => {
  // element ui Loading方法
  loadinginstace = Loading.service({ fullscreen: true })
  return config
}, error => {
  loadinginstace.close()
  Message.error({
    message: '加载超时'
  })
  return Promise.reject(error)
})
// http响应拦截器
axios.interceptors.response.use(data => {// 响应成功关闭loading
  loadinginstace.close();
  var error = {};
  if(data.data.code == 100000){
    router.push({path:'/login'});
    error.code= 100000;
    return Promise.reject(error)
  }else if(data.data.code == 500000){
    error.code= 500000;
    Message.error({
      message: '系统繁忙'
    })
    return Promise.reject(error)
  }else if(data.data.code == 200000){
    error.code= 200000;
    error.msg = data.data.message;
    return Promise.reject(error)
  }else {
    return data.data;
  }
}, error => {
  loadinginstace.close()
  Message.error({
    message: '系统繁忙'
  })
  return;
})

export default axios
