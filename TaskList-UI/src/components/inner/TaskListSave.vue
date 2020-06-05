<template>

   <div id = 'editor-content' class="mt-2">

     <table> 
      <tr>
        <td><p> Save Page </p></td>

       <td><p> Save Page </p></td>

        <td><p> Save Page </p></td>
      </tr>    
    </table>
    </div>

</template>

<script>

 
 
export default {
  name: 'TaskListSave',
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
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
.tab-button {
  padding: 6px 10px;
  border-top-left-radius: 3px;
  border-top-right-radius: 3px;
  border: 1px solid #ccc;
  cursor: pointer;
  background: #f0f0f0;
  margin-bottom: -1px;
  margin-right: -1px;
}
.tab-button:hover {
  background: #e0e0e0;
}
.tab-button.active {
  background: #e0e0e0;
}
.tab {
  border: 1px solid #ccc;
  padding: 10px;
}

.editor-column {
  max-height: 95%;
  overflow-y: auto;
}

.editor-content {
  display: flex;
  flex-direction: row;
}
</style>
