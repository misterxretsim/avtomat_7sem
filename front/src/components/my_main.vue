<template>
    <div class="my_main">
        <h1 v-if="this.$store.getters.modal === false">Посты: </h1>
        <posts v-if="this.$store.getters.modal === false"></posts>
        <add_post v-if="this.$store.getters.modal === false"></add_post>
        <modal v-else></modal>
    </div>
</template>

<script>
    import posts    from './posts.vue'
    import modal    from './modal.vue'
    import add_post from './add_post.vue'

    export default {
        name: 'my_main',
        components: {
            posts,
            add_post,
            modal
        },
        created() {
            this.$store.dispatch('getPosts')
        }
    }
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
