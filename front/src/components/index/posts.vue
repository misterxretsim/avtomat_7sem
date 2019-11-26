<template>
    <div>
        <b-card
            :title="post.title"
            v-for="post in this.$store.getters.posts"
            :key="post.id"
            class="my-3 mx-auto"
            style="width: 70vw; max-width: 550px"
        >
            <p class="disabled disabled-p">{{ post.author + ' | ' + post.date }}</p>
            <b-card-text>
                {{ post.body }}
            </b-card-text>
            <b-button
                variant="outline-danger"
                block
                @click="onDelete(post.id)"
                v-b-tooltip.hover
                title="Удалит данный пост навсегда"
            >Удалить</b-button>
        </b-card>
        <plus_post/>
    </div>
</template>

<script>
    import plus_post from './plus_post.vue'

    export default {
        name: "posts",
        components: {
            plus_post
        },
        methods: {
            onDelete(id) {
                this.$store.dispatch('deletePost', id)
            }
        }
    }
</script>

<style scoped>
    .disabled-p {
        color: #9a9a9a;
        font-size: 12px;
    }
</style>