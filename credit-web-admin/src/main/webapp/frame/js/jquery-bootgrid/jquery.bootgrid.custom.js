/**
 * Created by Gavin on 2017/3/7.
 */
$.extend( true, $.fn.bootgrid.Constructor.defaults, {
    navigation: 2,
    labels: {
        all: "全部",
        infos: "显示第{{ctx.start}}到{{ctx.end}}条记录，共{{ctx.total}}条记录",
        loading: "加载中...",
        noResults: "没有可显示内容!",
        refresh: "刷新",
        search: "搜索"
    },
    ajax: true
});