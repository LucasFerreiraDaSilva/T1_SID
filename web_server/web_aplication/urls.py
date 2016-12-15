from django.conf.urls import include, url
from . import views

urlpatterns = [

	url(r'^$', views.index),

	url(r'^form/cliente/$', views.cliente_form),
	url(r'^form/fabricante/$', views.fabricante_form),
	url(r'^form/peca/$', views.peca_form),
	url(r'^form/compra/$', views.compra_form),

	url(r'^edit/cliente/$', views.cliente_update),
	url(r'^edit/fabricante/$', views.fabricante_update),
	url(r'^edit/peca/$', views.peca_update),
	url(r'^edit/compra/$', views.compra_update),

	url(r'^list/cliente/$', views.cliente_list, name='list_cliente'),
	url(r'^list/peca/$', views.peca_list, name='list_peca'),
	url(r'^list/fabricante/$', views.fabricante_list, name='list_fabricante'),
	url(r'^list/compra/$', views.compra_list, name='list_compra'),
]
