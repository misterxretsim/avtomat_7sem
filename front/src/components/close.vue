<template>
    <div class="close">
        <div class="hide"></div>
        <b v-if="this.$store.getters.modal === false" class="close-x" @click="deletePost(post_id)">x</b>
        <b v-else class="close-x close-new" @click="closeModal">x</b>
    </div>
</template>

<script>
    export default {
        name: "close",
        props: {
            post_id: null
        },
        methods: {
            deletePost(post_id) {
                this.$store.dispatch('deletePost', post_id)
            },
            closeModal() {
                this.$store.commit('changeModal')
            }
        }
    }
</script>

<style scoped>
    .close {
        color: #ffc3be;
        font-size: 20px;
        width: 100%;
        height: 0;
        cursor: pointer;
        display: flex;
    }
    .hide {
        width: 95%;
    }
    .close-x {
        width: 2%;
        margin-top: 4px;
    }
    .close-new {
        color: lightgrey !important;
        font-size: 25px;
        transition: .3s;
    }
    .close-new:hover {
        color: grey !important;
    }
</style>