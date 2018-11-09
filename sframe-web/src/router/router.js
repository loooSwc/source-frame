import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/views/login/Login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: (resolve) => require(['../components/HelloWorld.vue'], resolve),
      children: [
        {
          path: '/home',
          name: 'home',
          component: (resolve) => require(['../components/Home.vue'], resolve),
          meta: {
            title:"home"
          }
        }
      ]
    },{
      path: '/login',
      name: 'Login',
      component: (resolve) => require(['../views/login/Login.vue'], resolve)
    }
  ]
})
