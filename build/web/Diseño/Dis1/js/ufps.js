/**
 * 
 * GUÍA DE ESTILOS PROGRAMA INGENIERÍA DE SISTEMAS
 * UNIVERSIDAD FRANCISCO DE PAULA SANTANDER
 * VERSIÓN 1.0.0
 * AUTOR: GERSON LÁZARO
 * REPORTES: gersonyesidlc@ufps.edu.co
 *
 *
 * 1. VENTANAS MODALES (Alertas)
 * 2. IMAGENES MODALES (Visualizador de imagen)
 * 3. DROPDOWN
 * 4. ACORDEÓN
 * 5. PESTAÑAS
 * 6. ALERTAS
 * 7. NOTIFICACIONES
 * 8. NAVBAR RESPONSIVE
 */


/**
 * VENTANAS MODALES (Alertas)
 * Este método se encarga de abrir una ventana modal
 * @param id - id de la ventana a abrir.
 */

function openModal(id) {
  var modal = document.getElementById(id);
  modal.style.display = "block";
  var close = document.getElementsByClassName("ufps-modal-close");
  for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
      modal.style.display = "none";
    }
  }
  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
}

/**
 * IMAGENES MODALES (Visualizador de imagen)
 * Este método se encarga de abrir la visualización en pantalla completa de una imagen, oscureciendo el fondo.
 * @param id - id del modal que contiene la imagen.
 */
function openModalImage(id) {
  var modal = document.getElementById(id);
  var modalImg = modal.getElementsByClassName("ufps-image-modal-content")[0];
  var captionText = modal.getElementsByClassName("ufps-image-modal-caption")[0];
  modal.style.display = "block";
  var close = document.getElementsByClassName("ufps-image-modal-close");
  for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
      modal.style.display = "none";
    }
  }
}


/**
 * DROPDOWN
 * Método encargado de permitir y ejecutar el despliegue y cierre de los dropdowns.
 * @param id - id del dropdown sobre a expandir.
 */
function openDropdown(id) {
  var dropdown = document.getElementById(id);
  window.onclick = function(event) {
    if (event.target.matches('.ufps-dropdown-btn') && event.target.parent != dropdown) {
      var dropdowns = document.getElementsByClassName("ufps-dropdown-content");
      var i;
      for (i = 0; i < dropdowns.length; i++) {
        var openDropdown = dropdowns[i];
        if (openDropdown.classList.contains('ufps-dropdown-show')) {
          openDropdown.classList.remove('ufps-dropdown-show');
        }
      }
      dropdown.getElementsByClassName("ufps-dropdown-content")[0].classList.toggle("ufps-dropdown-show");

    }
    if (!event.target.matches('.ufps-dropdown-btn')) {
      var dropdowns = document.getElementsByClassName("ufps-dropdown-content");
      var i;
      for (i = 0; i < dropdowns.length; i++) {
        var openDropdown = dropdowns[i];
        if (openDropdown.classList.contains('ufps-dropdown-show')) {
          openDropdown.classList.remove('ufps-dropdown-show');
        }
      }
    }
  }.bind(dropdown);
}

/**
 * ACORDEÓN
 * Método encargado de desplegar los diferentes acordeones en una web app. No es necesario pasar ningún parametro
 * Este método se ejecuta automáticamente con el evento onload y deja activos todos los acordeones existentes en la
 * página.
 */
function toggleAccordion() {
  var accordion = document.getElementsByClassName("ufps-btn-accordion");
  var i;
  for (i = 0; i < accordion.length; i++) {
    accordion[i].onclick = function() {
      this.classList.toggle("ufps-accordion-active");
      this.nextElementSibling.classList.toggle("ufps-accordion-show");
    }
  }
}

/**
 * PESTAÑAS
 * Método encargado de desplegar el contenido asociado a una pestaña. Debe dispararse al hacer clic en cualquiera de las pestañas 
 * @param evt - Evento que dispara el cambio
 * @param idTab - id del contenido que se desplegará al hacer clic
 * @param idContainer - id del contenedor de las pestañas
 */
function openTab(evt, idTab, idContainer) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementById(idContainer).getElementsByClassName("ufps-tab-content");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementById(idContainer).getElementsByClassName("ufps-tab-links");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" ufps-tab-active", "");
  }
  document.getElementById(idTab).style.display = "block";
  evt.currentTarget.className += " ufps-tab-active";
}

/**
 * ALERTAS
 * Añade funcionalidad al botón cerrar de las alertas. 
 * Este método se carga en el evento onload, y queda en espera por el cierre
 * @param event - Evento que dispara el cierre.
 */
function closeAlertListener(event) {
  var alerts = document.getElementsByClassName("ufps-close-alert-btn");
  var i = 0;
  for (i = 0; i < alerts.length; i++) {
    alerts[i].onclick = function(event) {
      event.target.parentElement.style.display = 'none';
    }
  }
}

/**
 * NOTIFICACIONES
 * Muestra una notificación en la parte inferior central de la pantalla.
 * @param text - Texto de la notificación
 * @param time - Tiempo que durará la alerta desplegada (en milisegundos)
 */
function notification(text, time) {
  var notification = document.createElement('div');
  notification.className = 'ufps-notification';
  notification.innerHTML = text;
  document.getElementsByTagName('body')[0].appendChild(notification);

  notification.className += " ufps-notification-show";

  setTimeout(function() {
    notification.className = notification.className.replace(" ufps-notification-show", "");
  }, time);

}

/**
 * NAVBAR RESPONSIVE
 * En dispositivos moviles y tabletas, los botones del menú se ocultan y solo se muestra un botón para desplegarlos.
 * Este método añade funcionalidad a dicho botón, permitiendo su despliegue y cierre.
 * @param id - Id del navbar
 */
function toggleMenu(id) {
  var navbar = document.getElementById(id);
  navbar.getElementsByClassName("ufps-btn-menu")[0].classList.toggle("ufps-change");
  var left = navbar.getElementsByClassName("ufps-navbar-left")[0];
  var right = navbar.getElementsByClassName("ufps-navbar-right")[0];
  if (left.style.display != "block") {
    left.style.display = "block";
    right.style.display = "block";

    setTimeout(function() {
      left.style.opacity = "1";
      right.style.opacity = "1";
    }, 100);
  } else {
    left.style.opacity = "0";
    right.style.opacity = "0";
    setTimeout(function() {
      left.style.display = "none";
      right.style.display = "none";
    }, 210);
  }

}

/**
 * Métodos que se ejecutan al inicializarse el documento html.
 */
window.onload = function() {
  toggleAccordion();
  closeAlertListener();
}