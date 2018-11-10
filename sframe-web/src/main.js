// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import sfMenu from './views/menu/menu'
import sfHeader from './views/header/header'
import sfFooter from './views/footer/footer'
import router from './router/router'
import './assets/css/animate.css'
import './assets/css/bootstrap.min.css'
import './assets/css/style.css'
import './assets/font-awesome/css/font-awesome.css'
import './assets/font-awesome/css/font-awesome.css'
import './assets/js/plugins/gritter/jquery.gritter.css'
import './assets/css/plugins/morris/morris-0.4.3.min.css'
import './assets/js/jquery-2.1.1.min.js'
import './assets/js/bootstrap.min.js?v=3.4.0'
import './assets/js/plugins/metisMenu/jquery.metisMenu.js'
import './assets/js/plugins/slimscroll/jquery.slimscroll.min.js'

Vue.config.productionTip = false

Vue.component('sf-menu',{
  template : {sfMenu},
  render: h => h(sfMenu)
});
Vue.component('sf-header',{
  template : {sfHeader},
  render: h => h(sfHeader)
});
Vue.component('sf-footer',{
  template : {sfFooter},
  render: h => h(sfFooter)
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  render: h => h(App)
})
