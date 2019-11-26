import Vue          from 'vue'
import VueResource  from 'vue-resource'
import BootstrapVue from 'bootstrap-vue'
import VueRouter    from 'vue-router'
import routes       from './routes'
import                   'bootstrap/dist/css/bootstrap.min.css'
import                   'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(VueResource);
Vue.use(VueRouter);
Vue.use(BootstrapVue);

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
});

export default router