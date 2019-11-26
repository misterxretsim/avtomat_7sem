import Vue    from 'vue'
import App    from './App.vue'
import router from './plugins/plugins'
import store  from './plugins/store/store'
import             '@babel/polyfill'
import             'mutationobserver-shim'
import             './plugins/plugins'

Vue.config.productionTip = false;

new Vue({
    store,
    router,
    render: h => h(App)
}).$mount('#app');
