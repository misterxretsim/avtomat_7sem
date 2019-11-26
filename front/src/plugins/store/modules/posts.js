// import resource from '../../../mixins/resource'

export default {
    actions: {
        getPosts(ctx) {
            // resource.post({/*какое-то тело запроса*/})
            //     .then((resp) => ctx.commit('updatePosts', resp.posts))
            //     .catch((e) => alert(`error ${e}`))
            ctx.commit('updatePosts', [
                {
                    id: 1,
                    author: 'Marina Kuzmina',
                    date: '26.10.2019',
                    title: 'Укрепление волос',
                    body: 'После того, как помыла голову, подсушила их на 40% естественным путём и потом наношу кератиновую водичку от Estel на ещё не расчесанные волосы.'
                },
                {
                    id: 2,
                    author: 'Marina Kuzmina',
                    date: '01.09.2019',
                    title: 'Масло лаванды',
                    body: 'C лавандовым маслом хорошо принимать ванны, они будут обладать двойным эффектом – ухаживать за кожей и успокаивать нервы, привлекая сон.'
                },
                {
                    id: 3,
                    author: 'Marina Kuzmina',
                    date: '22.08.2019',
                    title: 'Поговорим о коже',
                    body: 'Самый верхний слой кожи - роговой, и он меняется достаточно быстро. Можно его увлажнить, отшелушить, сгладить и все это быстро отразится на вашем внешнем виде кожи.'
                },
                {
                    id: 4,
                    author: 'Nikolay Kolesnik',
                    date: '10.07.2019',
                    title: 'Мармарис',
                    body: 'А вы знали, что Мармарис расположен на границе Средиземного моря с Эгейским? Город растянулся вдоль бухты, вокруг которой зеленые горы и яркая тропическая растительность.'
                },
            ])
        },
        deletePost(ctx, id) {
            // resource.post({/*какое-то тело запроса*/})
            //     .then((resp) => ctx.commit('updatePosts', resp.posts))
            //     .catch((e) => alert(`error ${e}`))
            ctx.commit('deletePost', id)
        },
        addPost(ctx, post) {
            ctx.commit('addPost', post)
        }
    },
    mutations: {
        updatePosts(state, posts) {
            state.posts = posts
        },
        deletePost(state, id) {
            state.posts.forEach((post, index, object) => {
                if (post.id === id) object.splice(index, 1)
            })
        },
        addPost(state, post) {
            state.posts.push(post)
        }
    },
    state: {
        posts: []
    },
    getters: {
        posts: (state) => state.posts
    }
}