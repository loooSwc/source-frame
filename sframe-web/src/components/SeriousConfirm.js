import _SeriousConfirm from './dialog.vue'
import Vue from 'vue'
import merge from '../assets/js/merge-option'

const SeriousConfirm = Vue.extend(_SeriousConfirm)
let vm;
export default (...arg) => {
  const defaultArg = {
    option: {
      title: '',
      width: '50%'
    },
    commit: function () {

    },
    cancel: function () {

    },
    param: {}
  }

  let opts

  // default
  if (arg.length === 0){
    opts = merge(defaultArg, {})
  }else {
    opts = merge(defaultArg, {
      option: arg[0],
      modalBody: arg[1],
      commit: arg[2],
      cancel: arg[3],
      param: arg[4]
    })
  }

  console.log(opts)
  vm = new SeriousConfirm({ propsData: opts }).$mount(document.body.appendChild(document.createElement('div')))

  return vm.open().then(result => {
    // destroy after dialog faded out
    setTimeout(() => {
      vm.$destroy()
      document.body.removeChild(vm.$el)
    }, 500)
    return result
  })
}
