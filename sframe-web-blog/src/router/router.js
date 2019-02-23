import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/home'
    },{
      path: '/home',
      name: 'home',
      component: (resolve) => require(['../views/home/home.vue'], resolve),
      redirect: '/home/list',
      children: [
        {
          path: 'list',
          component: (resolve) => require(['../views/home/list/blog-list.vue'], resolve)
        },
        {
          path: 'content',
          component: (resolve) => require(['../views/home/content/blog-content.vue'], resolve)
        }
      ]
    }
  ]
})
