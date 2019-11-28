<template>
    <div class="add_post">
        <center>
            <h1 class="mb-5 mt-3">Add new post</h1>
        </center>
        <b-form
            @submit.prevent="onSubmit"
            @reset.prevent
            style="width: 70vw; max-width: 550px;"
            class="mx-auto"
        >
            <b-form-group
                id="title-group"
                description="ex: How I traveled to Marmaris"
                label="Enter post's title:"
                label-for="title-input"
            >
                <b-form-input
                    id="title-input"
                    v-model="post.title"
                    placeholder="Topic"
                    :state="post.title.length >= 3"
                ></b-form-input>
            </b-form-group>
            <b-form-group
                id="author-group"
                description="Let us know your name."
                label="Enter your name:"
                label-for="author-input"
            >
                <b-form-input
                    id="author-input"
                    v-model="post.author"
                    placeholder="Kel Fish"
                    :state="post.author.length >= 3"
                ></b-form-input>
            </b-form-group>
            <b-form-group
                id="body-group"
                label="Enter text:"
                label-for="body-input"
            >
                <b-form-textarea
                    id="body-input"
                    style="min-height: calc(1.5em + .75rem + 2px);"
                    v-model="post.body"
                    placeholder="Some text on the topic on your post."
                    rows="3"
                    :state="post.body.length <= 200 && post.body.length >= 30"
                ></b-form-textarea>
            </b-form-group>
            <b-button
                @click="onSubmit"
                variant="outline-success"
                block
                class="mt-5 mb-4"
                v-b-tooltip.hover
                title="Добавить новый пост"
            >Добавить</b-button>
        </b-form>
    </div>
</template>

<script>
    export default {
        name: 'add_post',
        data() {
            return {
                post: {
                    title: '',
                    author: '',
                    body: ''
                }
            }
        },
        methods: {
            onSubmit() {
                const empty = { title: '', author: '', body: '' };
                if (this.post.body.length <= 200 && this.post.body.length >= 30 && this.post.author.length >= 3 && this.post.title.length >= 3) {
                    this.$store.dispatch('addPost', {
                        author: this.post.author,
                        date: this.getDate(new Date()),
                        title: this.post.title,
                        body: this.post.body
                    });
                    this.post = empty;
                    this.$bvToast.toast('Пост успешно добавлен!', {
                        title: 'Пост',
                        variant: 'success',
                        solid: true
                    })
                } else {
                    this.$bvToast.toast('Некорректные данные!', {
                        title: 'Ошибка',
                        variant: 'danger',
                        solid: true
                    })
                }
            },
            getDate(date) {
                return `${date.getDate()}.${date.getMonth() + 1}.${date.getFullYear()}`
            }
        }
    }
</script>