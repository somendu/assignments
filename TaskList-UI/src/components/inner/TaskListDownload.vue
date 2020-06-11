<template>
   <div id = 'task-list-download' class="mt-2">
      <table class="mt-2" border="1" width="100%"> 
      <tr>
        <td>
          <p> Name </p>
          <input id="name-input" type="text" size="40" v-model="value.consName"/>
        </td>

       <td><p> Date From </p>
            <datepicker placeholder="Select Date" size="40" v-model="value.dateFrom" format="dd-MM-yyyy" name="dateFrom"></datepicker>
       </td>

       <td><p> Date From </p>
            <datepicker placeholder="Select Date" size="40" v-model="value.dateTo" format="dd-MM-yyyy" name="dateTo"></datepicker>
       </td>          
      </tr>
    </table>
    <br><br>
    <div id="task-download">
 
           <input id="download-button" type="Button" value="Download"  v-on:click="downloadExcel()"/>
           &nbsp;&nbsp;&nbsp;
           <input id="cancel-button" type="Button" value="Cancel"/>
        
     </div>
    </div>
</template>

<script>

import Datepicker from "vuejs-datepicker/dist/vuejs-datepicker.esm.js";
import ExcelJs from "exceljs";
import Stream from "exceljs"

function pad2 (num) {
  if (num < 10) return '0' + num;
  return num;
}

function formatDate (value) {
  return pad2(value.getDate() + '-' + pad2(value.getMonth() + 1) + '-' + value.getFullYear());
}

function parseDate (value) {
  if (typeof value === 'string' && value.length === 10) {
    const day = parseInt(value.substring(0, 1), 10);
    const month = parseInt(value.substring(3, 5), 10);
    const year = parseInt(value.substring(7), 10);

    if (!isNaN(year) && !isNaN(month) && !isNaN(day)) {
      return new Date(year, month - 1, day);
    }
  }

  return null;
} 

export default {
  name: 'TaskListDownload',


  components: {
    Datepicker
  }, 

  data(){
  return {
   
   value: {
    consName: '',
    dateFrom: new Date(),
    dateTo: new Date() + 30
    }, 

    error: '',
    wb2: new ExcelJs.Workbook()

  }
	},

  methods: {

    set (value) {
       value.dateFrom = parseDate(value.dateFrom);
       value.dateTo = parseDate(value.dateTo);    
         this.$set(this, 'value', value);
    },

    downloadExcel(){
    
    const result = {};

      for (let key of Object.keys(this.value)) {
        if (this.value[key] != null && this.value[key] !== '') {
          result[key] = this.value[key];
        }
      }

    this.value.dateFrom = formatDate(result.dateFrom);
    this.value.dateTo = formatDate(result.dateTo);

    
    fetch('/api/downloadTaskList', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          consName: this.value.consName,
          dateFrom: this.value.dateFrom,
          dateTo: this.value.dateTo
        })
      })
      .then(this.fetchResponseHandler)
      .catch(err => {
      this.error = err;
      console.error('There was an error!', err);
    });
    
    this.value.consName = '';
    this.value.dateFrom = new Date();
    this.value.dateTo = new Date();
 
  }, 
    
    fetchResponseHandler (res) {

   res.body
     .getReader()
     .read()
     .then(({value, done}) => {
         
            const blob = new Blob([value], { type: res.headers.get('Content-Type') })
    const url = window.URL.createObjectURL(blob)
    const link = document.createElement('a')
    link.href = url
    let contentDisposition = res.headers.get('Content-Disposition');

    let fileNameMatch = '';

    if (contentDisposition) {
      fileNameMatch = contentDisposition.substring(21, contentDisposition.length);
    }

    link.setAttribute('download', fileNameMatch);
    link.click()
     })

    
    

    },
    
  }

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
</style>
