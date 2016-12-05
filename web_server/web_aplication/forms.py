from django import forms
from .models import *


class ClienteForm(forms.ModelForm):
	class Meta:
		model = Cliente
		fields = '__all__'

class FabricanteForm(forms.ModelForm):
	class Meta:
		model = Fabricante
		fields = '__all__'

class PecaForm(forms.ModelForm):
	class Meta:
		model = Peca
		fields = ['descricao', 'valor_unit', 'fabricante']

class CompraForm(forms.ModelForm):
	class Meta:
		model = Compra
		fields = '__all__'
