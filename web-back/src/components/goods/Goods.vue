<template>
    <div class="goodsTable">
        <div class="option">
            <button @click="changeIsAdd">新增</button>
            <button>导出</button>
        </div>
        <AddGoods @changeIsAdd="changeIsAdd" @onlyChangeAdd="onlyChangeIsAdd" class="addGoods" v-if="isAdd === 1" />
        <EditGoods @changeIsEdit="changeIsEdit" :goodsMes="data" :nowId="nowId" class="addGoods" v-if="isEdit === 1" />
        <TableMes :tableMes="tableMes" :tableTitle="tableTitle" :tableHeight="tableHeight" :tableWidth="tableWidth"
            @editMes="editMes" @deleteMes="deleteMes" />
        <TableList @setPage="setPage" @setIndex="setIndex" :index="index" :page="page" :allLen="allLen" />
    </div>
</template>

<script>
import { v4 as uuidv4 } from 'uuid';
import { ref } from 'vue';
import $ from 'jquery'
import TableList from '../tableList.vue';
import TableMes from '../tableMes.vue';
import { useStore } from 'vuex';
import AddGoods from './addGoods.vue';
import EditGoods from './editGoods.vue';

export default {
    name: 'GoodsTable',
    components: {
        TableList,
        TableMes,
        AddGoods,
        EditGoods
    },
    setup() {
        const store = useStore();
        let isAdd = ref(0);
        let nowId = ref(-1);
        let isEdit = ref(0);
        let data = ref({});
        let allLen = ref(0.0);
        let index = ref(3.0);
        let page = ref(1.0);
        let search = ref('');
        let pageItem = ref(1);
        let url = ref('http://localhost:3000/query/goods?' + 'index=' + index.value + '&page=' + page.value);
        const tableWidth = [
            '64px', '130px', '130px', '64px', '64px', '200px', '200px'
        ]
        const tableHeight = { height: '100px' };
        const tableTitle = ref([
            { id: uuidv4, name: '序号', style: { width: tableWidth[0] } },
            { id: uuidv4, name: '名字', style: { width: tableWidth[1] } },
            { id: uuidv4, name: '图片', style: { width: tableWidth[2] } },
            { id: uuidv4, name: '状态', style: { width: tableWidth[3] } },
            { id: uuidv4, name: '价格', style: { width: tableWidth[4] } },
            { id: uuidv4, name: '创建时间', style: { width: tableWidth[5] } },
            { id: uuidv4, name: '修改时间', style: { width: tableWidth[6] } },
        ])
        const tableMes = ref([]);
        const getAllLen = () => {
            $.ajax({
                url: 'http://localhost:3000/query/goods',
                type: 'get',
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success: (resp) => {
                    allLen.value = resp.data.length;
                }
            })
        }
        getAllLen();

        const getGoods = () => {
            tableMes.value = [];
            $.ajax({
                url: url.value,
                type: 'get',
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success: (resp) => {
                    data.value = resp;
                    for (let i = 0; i < resp.data.length; i++) {
                        const data = resp.data[i];
                        const GoodsId = resp.data[i].id;
                        const cT = new Date(data.createTime);
                        const uT = new Date(data.updateTime);
                        data.createTime = cT.getFullYear() + '-' + (cT.getMonth() + 1) + '-' + cT.getDate() + ' ' + cT.getHours() + ':' + cT.getMinutes() + ':' + cT.getSeconds();
                        data.updateTime = uT.getFullYear() + '-' + (uT.getMonth() + 1) + '-' + uT.getDate() + ' ' + uT.getHours() + ':' + uT.getMinutes() + ':' + uT.getSeconds();
                        const aGoods = [
                            { id: uuidv4, type: 'data', mes: resp.data.length - i + (page.value - 1) * index.value, style: { width: tableWidth[0], height: '100px' } },
                            { id: uuidv4, type: 'data', mes: data.name, style: { width: tableWidth[1], height: '100px' } },
                            { id: uuidv4, type: 'url', mes: data.photoUrl, style: { width: tableWidth[2], height: '100px' } },
                            { id: uuidv4, type: 'data', mes: data.status, style: { width: tableWidth[3], height: '100px' } },
                            { id: uuidv4, type: 'data', mes: data.price, style: { width: tableWidth[4], height: '100px' } },
                            { id: uuidv4, type: 'data', mes: data.createTime, style: { width: tableWidth[5], height: '100px' } },
                            { id: uuidv4, type: 'data', mes: data.updateTime, style: { width: tableWidth[6], height: '100px' } },
                        ]
                        tableMes.value.unshift({ id: uuidv4, GoodsId, data: aGoods });
                    }
                }
            })
        }
        getGoods();
        const changeIsAdd = () => {
            getGoods();
            isAdd.value = 1 - isAdd.value;
            getAllLen();
        }

        const editMes = (i) => {
            nowId.value = i;
            isEdit.value = 1 - isEdit.value;
        }

        const deleteMes = (i) => {
            $.ajax({
                url: 'http://localhost:3000/delete/goods',
                type: 'post',
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                data: {
                    id: tableMes.value[i].GoodsId,
                },
                success: (resp) => {
                    console.log(resp);
                    getGoods();
                }
            })
        }

        const onlyChangeIsAdd = () => {
            isAdd.value = 1 - isAdd.value;
        }

        const changeIsEdit = () => {
            isEdit.value = 1 - isEdit.value
            getGoods();
        }

        const setIndex = (i) => {
            index.value = i;
            url.value = 'http://localhost:3000/query/goods?' + 'index=' + index.value + '&page=' + page.value;
            setPage(1);
        }

        const setPage = (i) => {
            page.value = i;
            url.value = 'http://localhost:3000/query/goods?' + 'index=' + index.value + '&page=' + page.value;
            getGoods();
        }

        return {
            tableWidth,
            tableHeight,
            tableTitle,
            tableMes,
            isAdd,
            isEdit,
            nowId,
            data,
            allLen,
            index,
            page,
            search,
            pageItem,
            onlyChangeIsAdd,
            changeIsAdd,
            editMes,
            deleteMes,
            changeIsEdit,
            setIndex,
            setPage
        }
    }
}

</script>

<style scoped>
.option {
    height: 50px;
    width: 94%;
    margin: 10px 3% 0 3%;
    display: flex;
    align-items: center;
    justify-content: center;
}

.option>button {
    height: 40px;
    width: 80px;
    font-size: 16px;
    border: 0;
    border-radius: 5px;
    background-color: green;
    margin: 0 10px 0 10px;
    color: rgba(240, 169, 63, 0.966);
}

.addGoods {
    position: absolute;
    top: 64px;
    left: calc(10%);
    z-index: 1;
}
</style>