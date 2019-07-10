# Practice2 description

界面包括：

- 头图
- 更新日期
- 可滑动的热搜列表（recyclerview)
- 热搜标志（热、新）

功能实现：

- 在页面布局中加入recyclerview标签
- 定义其中每一个item的布局文件icon_item_XXX.xml
- 重写构造ViewHolder类
- 重写IconAdapter中onCreateViewHolder，onBindViewHolder，
- getItemCount，getItemViewType，其中利用getItemViewType决定调用不同的inflate布局文件，来达到显示不同item布局的效果

