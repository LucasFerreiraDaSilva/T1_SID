from django.shortcuts import render
from django.contrib import messages
from .forms import *
from .models import *
from .requisicoes import *

def index(request):
    listFabricante()
    return render(request, 'web_aplication/index.html', locals())

# VIEWS DE CADASTRO

def cliente_form(request):
    if request.method == "POST":
        form = ClienteForm(request.POST)
        if form.is_valid():
            dic = (request.POST).dict()
            del dic['csrfmiddlewaretoken']
            print(dic)
            form.save()
            messages.success(request, "Cliente cadastrado com sucesso")
    else:
        form = ClienteForm()
    return render(request, 'web_aplication/cliente_form.html', locals())

def fabricante_form(request):
    if request.method == "POST":
        form = FabricanteForm(request.POST)
        if form.is_valid():
            form.save()
            messages.success(request, "Fabricante cadastrado com sucesso")
    else:
        form = FabricanteForm()
    return render(request, 'web_aplication/fabricante_form.html', locals())

def peca_form(request):
    if request.method == "POST":
        form = PecaForm(request.POST)
        if form.is_valid():
            form.save()
            messages.success(request, "Peça cadastrado com sucesso")
    else:
        form = PecaForm()
    return render(request, 'web_aplication/peca_form.html', locals())

def compra_form(request):
    if request.method == "POST":
        form = CompraForm(request.POST)
        if form.is_valid():
            form.save()
            messages.success(request, "Compra realiazada com sucesso")
    else:
        form = CompraForm()
    return render(request, 'web_aplication/compra_form.html', locals())

# VIEWS DE LISTAGEM

def cliente_list(request):
	clientes = Cliente.objects.all()
	if request.method == "POST":
		for cliente in request.POST.getlist("check_clientes"):
			Cliente.objects.filter(id=cliente).delete()
	return render(request, "web_aplication/clientes_list.html", locals())

def fabricante_list(request):
    fabricantes = Fabricante.objects.all()
    listFabricante()
    if request.method == "POST":
        for fabricante in request.POST.getlist("check_fabricantes"):
            Fabricante.objects.filter(id=fabricante).delete()
    return render(request, "web_aplication/fabricantes_list.html", locals())

def peca_list(request):
    pecas = Peca.objects.all()
    listPecas()
    if request.method == "POST":
        for peca in request.POST.getlist("check_pecas"):
            Peca.objects.filter(id=peca).delete()
    return render(request, "web_aplication/pecas_list.html", locals())

def compra_list(request):
    compras = Compra.objects.all()
    listCompras()
    if request.method == "POST":
        for compra in request.POST.getlist("check_compras"):
            Compra.objects.filter(id=compra).delete()
    return render(request, "web_aplication/compras_list.html", locals())

# VIEWS DE UPDATE
