import Vue from 'vue'
import Router from 'vue-router'
import login from '@/views/login/login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: (resolve) => require(['../components/HelloWorld.vue'], resolve),
      redirect: '/login'
    },{
      path: '/login',
      name: 'login',
      component: (resolve) => require(['../views/login/login.vue'], resolve)
    },{
      path: '/home',
      name: 'home',
      component: (resolve) => require(['../views/home/home.vue'], resolve)
    }
  ]
})
