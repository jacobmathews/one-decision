/*******************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
var EASING_DURATION = 500;
fadeOutMessages = true;
var newLineRegEx = /\n/g;


/**
 * Base class to handle common behaviour for each single-page-application to extend. 
 * 
 * Provides login support, some standard controls like Typeahead etc.
 *
 * Form names expected:
 *   login
 */
var OneDecisionApp = Ractive.extend({
  ajaxSetup: function() {
    console.log('ajaxSetup: '+this);
    $.ajaxSetup({
      username: localStorage['username'],
      password: localStorage['password'],
      error: this.handleError
    });
  },
  applyBranding: function() {
    // ajax loader 
    $( "#ajax-loader" ).remove();
    $('body').append('<div id="ajax-loader"><img class="ajax-loader" src="images/one-decision-ajax-loader.gif" alt="Loading..."/></div>');
    $( document ).ajaxStart(function() {
      $( "#ajax-loader" ).show();
    });
    $( document ).ajaxStop(function() {
      $( "#ajax-loader" ).hide();
    });
  },
  fetchProfile: function() {
    console.info('fetchProfile');
    $.getJSON('/profile/', function( data ) {
      console.log('loaded profile...');
      ractive.set('profile', data);
      ractive.set('roles', data.roles);
    });
  },
  handleError: function(jqXHR, textStatus, errorThrown) {
    switch (jqXHR.status) {
    case 400:
      var msg = jqXHR.responseJSON == null ? textStatus+': '+errorThrown : errorThrown+': '+jqXHR.responseJSON.message;
      ractive.showError(msg);
      break; 
    case 401:
    case 403: 
    case 405:
      ractive.showError("Session expired, please login again");
      window.location.href='/login';
      break; 
    default: 
      var msg = "Bother! Something has gone wrong (code "+jqXHR.status+"): "+textStatus+':'+errorThrown;
      console.error('msg:'+msg);
      ractive.showError(msg);
    }
  },
  hasRole: function(role) {
    if (ractive.get('roles')==undefined) return true;
    else return ractive.get('roles').indexOf(role)!=-1;
  },
  getServer: function() {
    return ractive.get('server')==undefined ? '' : ractive.get('server');
  },
  hash: function(email) {
    return hex_md5(email.trim().toLowerCase());
  },
  hideMessage: function() {
    $('#messages').hide();
  },
  initAutoComplete: function() {
    console.log('initAutoComplete');
    if (ractive.get('typeaheadControls')!=undefined && ractive.get('typeaheadControls').length>0) {
      $.each(ractive.get('typeaheadControls'), function(i,d) {
        console.log('binding ' +d.url+' to typeahead control: '+d.selector);
        $.get(ractive.getServer()+d.url, function(data){
          if (d.name!=undefined) ractive.set(d.name,data); 
          $(d.selector).typeahead({ items:'all',minLength:0,source:data });
          $(d.selector).on("click", function (ev) {
            newEv = $.Event("keydown");
            newEv.keyCode = newEv.which = 40;
            $(ev.target).trigger(newEv);
            return true;
         });
        },'json');
      });
    }
  },
  initAutoNumeric: function() { 
    if ($('.autoNumeric')!=undefined && $('.autoNumeric').length>0) {
      $('.autoNumeric').autoNumeric('init', {});
    }
  },
  initContentEditable: function() {
    console.log('initContentEditable');
    $("[contenteditable]").focus(function() { 
      console.log('click '+this.id);
      selectElementContents(this);
    });
  },
  initControls: function() { 
    console.log('initControls');
    ractive.initAutoComplete();
    ractive.initAutoNumeric();
    ractive.initDatepicker();
    ractive.initContentEditable();
  },
  initDatepicker: function() {
    console.log('initDatepicker');
    if ($('.datepicker')!=undefined && $('.datepicker').length>0) {
      $('.datepicker').datepicker({
        format: "dd/mm/yyyy",
        autoclose: true,
        todayHighlight: true
      });
    }
  },
  loadStandardPartials: function(stdPartials) {
    $.each(stdPartials, function(i,d) {
      console.log('loading...: '+d.name)
      $.get(d.url, function(response){
        console.log('... loaded: '+d.name)
        //console.log('response: '+response)
        if (ractive != undefined) ractive.resetPartial(d.name,response);
      });
    });
  },
  login: function() {
    console.log('login');
    if (!document.forms['loginForm'].checkValidity()) {
      // TODO message
      return false;
    }
    localStorage['username'] = $('#username').val();
    localStorage['password'] = $('#password').val();
    document.forms['loginForm'].submit();
  },
  logout: function() {
    localStorage['username'] = null;
    localStorage['password'] = null;
    document.cookie = this.CSRF_COOKIE+'=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    document.forms['logoutForm'].submit();
  },
  showError: function(msg) {
    this.showMessage(msg, 'bg-danger text-danger');
  },
  showFormError: function(formId, msg) {
    this.showError(msg);
    var selector = formId==undefined || formId=='' ? ':invalid' : '#'+formId+' :invalid';
    $(selector).addClass('field-error');
    $(selector)[0].focus();
  },
  showMessage: function(msg, additionalClass) {
    console.log('showMessage: '+msg);
    if (additionalClass == undefined) additionalClass = 'bg-info text-info';
    if (msg === undefined) msg = 'Working...';
    $('#messages').empty().append(msg).removeClass().addClass(additionalClass).show();
//    document.getElementById('messages').scrollIntoView();
    if (fadeOutMessages && additionalClass!='bg-danger text-danger') setTimeout(function() {
      $('#messages').fadeOut();
    }, EASING_DURATION*10);
    else $('#messages').append('<span class="text-danger pull-right glyphicon glyphicon-remove" onclick="ractive.hideMessage()"></span>');
  }
});

function selectElementContents(el) {
  var range = document.createRange();
  range.selectNodeContents(el);
  var sel = window.getSelection();
  sel.removeAllRanges();
  sel.addRange(range);
}

function getSearchParameters() {
  var prmstr = window.location.search.substr(1);
  return prmstr != null && prmstr != "" ? transformToAssocArray(prmstr) : {};
}

function transformToAssocArray( prmstr ) {
  var params = {};
  var prmarr = prmstr.split("&");
  for ( var i = 0; i < prmarr.length; i++) {
      var tmparr = prmarr[i].split("=");
      params[tmparr[0]] = tmparr[1];
  }
  return params;
}
