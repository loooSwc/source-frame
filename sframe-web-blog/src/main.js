import Vue from 'vue'
import App from './App'
import 'element-ui/lib/theme-chalk/index.css';
import Element from 'element-ui';
import './style/style.css';
import axios from './axios/axios';
import tablePage from './axios/service';
import moment from 'moment'
import router from './router/router'
import SeriousConfirm from './components/SeriousConfirm.js';
import 'font-awesome/css/font-awesome.css';

Vue.use(Element);

Vue.config.productionTip = false;
Vue.prototype.$axios = axios;
Vue.prototype.$service = tablePage;
Vue.prototype.$dialog = SeriousConfirm;
// 定义全局过滤器--时间格式化
Vue.prototype.dataFormat=function(row, column, cellValue, index) {
  return moment(cellValue).format('YYYY-MM-DD HH:mm:ss')
}

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  render: h => h(App)
})

