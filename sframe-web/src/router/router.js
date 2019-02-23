import Vue from 'vue'
import Router from 'vue-router'
import login from '@/views/login/login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login'
    },{
      path: '/login',
      name: 'login',
      component: (resolve) => require(['../views/login/login.vue'], resolve)
    },{
      path: '/home',
      name: 'home',
      component: (resolve) => require(['../views/home/home.vue'], resolve),
      redirect: '/home/user/list',
      children: [
        {
          path: 'user/list',
          component: (resolve) => require(['../views/user/user-list.vue'], resolve)
        },
        {
          path: 'business/blog/list',
          component: (resolve) => require(['../views/blog/list/blog-list.vue'], resolve)
        }
      ]
    }
  ]
})
