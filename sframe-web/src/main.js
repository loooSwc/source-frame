// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router/router'
import 'element-ui/lib/theme-chalk/index.css';
import Element from 'element-ui';
import './style/style.css';
import './assets/css/bootstrap.min.css'

Vue.use(Element, { size: 'small', zIndex: 3000 });

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  render: h => h(App)
})
