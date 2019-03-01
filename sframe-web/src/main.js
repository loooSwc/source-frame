// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import 'element-ui/lib/theme-chalk/index.css';
import Element from 'element-ui';
import './style/style.css';
import axios from './axios/axios';
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import 'mavon-editor/dist/markdown/github-markdown.min.css'
import tablePage from './axios/service';
import moment from 'moment'
import router from './router/router'
import SeriousConfirm from './components/SeriousConfirm.js'
import fontawesome from '@fortawesome/fontawesome'
import FontAwesomeIcon from '@fortawesome/vue-fontawesome'
import solid from '@fortawesome/fontawesome-free-solid'
import regular from '@fortawesome/fontawesome-free-regular'
import brands from '@fortawesome/fontawesome-free-brands'

fontawesome.library.add(solid)
fontawesome.library.add(regular)
fontawesome.library.add(brands)

Vue.component('font-awesome-icon', FontAwesomeIcon)
Vue.use(Element, { size: 'small', zIndex: 3000 });
Vue.use(mavonEditor)

Vue.config.productionTip = false;
Vue.prototype.$axios = axios;
Vue.prototype.$service = tablePage;
Vue.prototype.$dialog = SeriousConfirm;
// 定义全局过滤器--时间格式化
Vue.prototype.dataFormat=function(row, column, cellValue, index) {
  return moment(cellValue).format('YYYY-MM-DD HH:mm:ss')
}
Vue.prototype.$markdown = function (value) {
  return mavonEditor.markdownIt.render(value)
}

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  render: h => h(App)
})

