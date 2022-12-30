<template>
    <div class="addGoods">
        <div class="addMes">
            <div>
                <label for="name">商品名</label>
                <input style="width: calc(100% - 70px)" name="name" type="text" v-model="Goodsname">
            </div>
            <div>
                <label for="tags">标签</label>
                <input style="width: calc(100% - 70px)" name="tags" type="text" v-model="tags">
            </div>
            <div>
                <label for="photo"
                    style="width: 100%; display: flex;align-items: center;justify-content: center;">商品封面</label>
                <input style="width: 100%;" name="multipartFile" type="file" @change="getPhoto">
            </div>
            <div>
                <label for="price">价格</label>
                <input style="width: calc(100% - 70px)" name="price" type="text" v-model="price">
            </div>
            <div>
                <label for="shopid">商店名</label>
                <input style="width: calc(100% - 70px)" name="shopid" type="text" v-model="shopName">
            </div>
            <div v-if="errorMes !== ''"></div>
            <button @click="submit">提交</button>
            <button @click="onlyChangeAdd">取消</button>
        </div>
    </div>

</template>

<script>
import { ref } from 'vue';
import $ from 'jquery'
import { useStore } from 'vuex';
// import uploadPhoto from './uploadPhoto.vue';

export default {
    name: 'AddGoods',
    props: ['changeIsAdd'],
    emits: ['onlyChangeAdd'],
    // components: { uploadPhoto },
    setup(_, context) {
        let Goodsname = ref(''), tags = ref(''), price = ref(''), shopName = ref(''), photo = ref(), errorMes = ref(''), url = '';
        const store = useStore();
        const submit = () => {
            $.ajax({
                url: 'http://localhost:3000/add/goods',
                type: 'post',
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                data: {
                    name: Goodsname.value,
                    tag: tags.value,
                    url,
                    price: price.value,
                    shopName: shopName.value
                },
                success: (resp) => {
                    if (resp.error_message === 'success')
                        context.emit("changeIsAdd");
                    else errorMes.value = resp.error_message;
                }
            })
        }

        const getPhoto = (event) => {
            let multipartFile = new FormData();
            multipartFile.append('multipartFile', event.target.files[0], event.target.files[0].name);
            $.ajax({
                url: 'http://localhost:3000/add/photo',
                type: 'post',
                data: multipartFile,
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                cache: false,
                processData: false,
                contentType: false,
                success: resp => {
                    url = resp.photo_url;
                },
                error(resp) {
                    console.log(resp);
                }
            })
        }

        const onlyChangeAdd = () => {
            context.emit("onlyChangeAdd");
        }
        return {
            Goodsname,
            tags,
            price,
            shopName,
            photo,
            errorMes,
            getPhoto,
            submit,
            onlyChangeAdd,
            // submitPhoto
        }
    }
}

</script>

<style scoped>
.addGoods {
    width: 90%;
    height: calc(100% - 64px);
    background-color: rgba(255, 255, 255, 0.486);
    display: flex;
    align-items: center;
    justify-content: center;
}

.addMes {
    width: 500px;
    height: 400px;
    background-color: whitesmoke;
    border-radius: 10px;
    box-shadow: 0px 0px 5px gray;
    padding: 10px;
}

.addMes>button {
    height: 40px;
    border-radius: 20px;
    width: 50%;
    border: 0;
    background-color: rgb(69, 112, 230);
    color: white;
}

.addMes>div {
    height: 52px;
    margin-bottom: 12px;
    display: flex;
    align-items: center;
    flex-shrink: 0;
    flex-wrap: wrap;
}

.addMes>div>label {
    width: 70px;
    display: flex;
    align-items: center;
    justify-content: center;
}

.addMes>div>input {
    height: 36px;
    /* width: calc(100% - 70px); */
    border-radius: 18px;
    border: 1px solid greenyellow;
    padding: 0 18px 0 18px;
}

.position {
    width: 80px;
}

.radio {
    width: 15px;
    height: 15px;
}
</style>