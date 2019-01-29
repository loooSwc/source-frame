<template>
  <el-dialog
    :visible="visible"
    :before-close="close"
    :title="option.title"
    :width="option.width"
  >
    <div class="dialog-body" solt="">
      <component :is="modalBody" ref="forms" @close="close" @commit="ok" :param="param"></component>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: 'serious-confirm',
  data: () => ({
    resolve: null,
    promise: null
  }),
  props: {
    option: {},
    modalBody: Function,
    commit: Function,
    cancel: Function,
    param: {}
  },
  computed: {
    visible() {
      return Boolean(this.resolve)
    }
  },
  methods: {
    open() {
      return this.promise = new Promise(r => this.resolve = r)
    },
    close(arg){
      if (this.resolve) {
        this.resolve = null
        this.cancel(arg);
      }
    },
    ok(arg){
      if (this.resolve) {
        this.resolve = null
        this.commit(arg);
      }
    }
  }
}
</script>

