from django.conf.urls import include, url
from . import views

urlpatterns = [

	url(r'^form/cliente/$', views.cliente_form),
	url(r'^form/fabricante/$', views.fabricante_form),
	url(r'^form/peca/$', views.peca_form),
	url(r'^form/compra/$', views.compra_form),

	url(r'^list/cliente/$', views.cliente_list),
	url(r'^list/peca/$', views.peca_list),
	url(r'^list/fabricante/$', views.fabricante_list),
	url(r'^list/compra/$', views.compra_list),
]
