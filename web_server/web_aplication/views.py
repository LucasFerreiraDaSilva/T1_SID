from django.shortcuts import render, get_object_or_404, redirect
from django.contrib import messages
from .forms import *
from .models import *
from .requisicoes import *


def index(request):
    #sincAllModels()
    return render(request, 'web_aplication/index.html', locals())

################### UPDATE ###################
def cliente_update(request):
    if request.method == 'GET':
        id = request.GET.get('id')
        cliente = get_object_or_404(Cliente, id=id)

    elif request.method == 'POST':
        id = request.POST.get('id')
        cliente = get_object_or_404(Cliente, id=id)
        n_nome = request.POST.get('nome')
        n_cpf = request.POST.get('cpf')

        cliente.nome = n_nome
        cliente.cpf = n_cpf
        cliente.save()

        return redirect('list_cliente')
    return render(request, 'web_aplication/cliente_edit.html', locals())

def fabricante_update(request):
    if request.method == 'GET':
        id = request.GET.get('id')
        fabricante = get_object_or_404(Fabricante, id=id)

    elif request.method == 'POST':
        id = request.POST.get('id')
        fabricante = get_object_or_404(Fabricante, id=id)
        n_nome = request.POST.get('nome')
        n_cnpj = request.POST.get('cnpj')

        fabricante.nome = n_nome
        fabricante.cnpj = n_cnpj
        fabricante.save()

        return redirect('list_fabricante')
    return render(request, 'web_aplication/fabricante_edit.html', locals())

def peca_update(request):
    if request.method == 'GET':
        id = request.GET.get('id')
        peca = get_object_or_404(Peca, id=id)
        fabricantes = Fabricante.objects.values()
        pecafab = peca.fabricante.id

    elif request.method == 'POST':
        id = request.POST.get('id')
        peca = get_object_or_404(Peca, id=id)
        n_descricao = request.POST.get('descricao')
        n_valor_unit = request.POST.get('valor_unit')
        n_fabricante = Fabricante.objects.get(pk=request.POST.get('id_fabricante'))

        peca.descricao = n_descricao
        peca.valor_unit = n_valor_unit
        peca.fabricante = n_fabricante
        peca.save()

        return redirect('list_peca')
    return render(request, 'web_aplication/peca_edit.html', locals())

def compra_update(request):
    if request.method == 'GET':
        id = request.GET.get('id')
        compra = get_object_or_404(Compra, id=id)
        clientes = Cliente.objects.values()
        pecas = Peca.objects.values()
        compracli = compra.cliente.id
        comprapeca = compra.peca.id

    elif request.method == 'POST':
        id = request.POST.get('id')
        compra = get_object_or_404(Compra, id=id)

        n_quantidade = request.POST.get('quantidade')
        n_data = request.POST.get('data')
        n_cliente = Cliente.objects.get(pk=request.POST.get('id_cliente'))
        n_peca = Peca.objects.get(pk=request.POST.get('id_peca'))

        compra.quantidade = n_quantidade
        compra.data = n_data
        compra.cliente = n_cliente
        compra.peca = n_peca
        compra.save()

        return redirect('list_compra')
    return render(request, 'web_aplication/compra_edit.html', locals())

################### CREATE ###################
def cliente_form(request):
    if request.method == "POST":
        form = ClienteForm(request.POST)
        if form.is_valid():
            dic = (request.POST).dict()
            del dic['csrfmiddlewaretoken']
            print(dic)

            form.save()
            messages.success(request, "Cliente cadastrado com sucesso")
            return redirect('list_cliente')
    else:
        form = ClienteForm()
    return render(request, 'web_aplication/cliente_form.html', locals())


def fabricante_form(request):
    if request.method == "POST":
        form = FabricanteForm(request.POST)
        if form.is_valid():
            dic = (request.POST).dict()
            del dic['csrfmiddlewaretoken']
            print(dic)

            form.save()
            messages.success(request, "Fabricante cadastrado com sucesso")
            return redirect('list_fabricante')
    else:
        form = FabricanteForm()
    return render(request, 'web_aplication/fabricante_form.html', locals())

def peca_form(request):
    if request.method == "POST":
        form = PecaForm(request.POST)
        if form.is_valid():
            dic = (request.POST).dict()
            del dic['csrfmiddlewaretoken']
            print(dic)

            form.save()
            messages.success(request, "Peça cadastrada com sucesso")
            return redirect('list_peca')
    else:
        form = PecaForm()
    return render(request, 'web_aplication/peca_form.html', locals())

def compra_form(request):
    if request.method == "POST":
        form = CompraForm(request.POST)
        if form.is_valid():
            dic = (request.POST).dict()
            del dic['csrfmiddlewaretoken']
            print(dic)

            form.save()
            messages.success(request, "Compra realiazada com sucesso")
            return redirect('list_compra')
    else:
        form = CompraForm()
    return render(request, 'web_aplication/compra_form.html', locals())

################### LIST ###################

def cliente_list(request):
    clientes = Cliente.objects.all()

    if request.method == 'POST':
        id = request.POST.get('id_del')
        Cliente.objects.filter(id=id).delete()
            #deleteCliente(cliente)
    return render(request, "web_aplication/clientes_list.html", locals())

def fabricante_list(request):
    fabricantes = Fabricante.objects.all()

    if request.method == "POST":
        id = request.POST.get('id_del')
        Fabricante.objects.filter(id=id).delete()
        #deleteFabricante()
    return render(request, "web_aplication/fabricantes_list.html", locals())

def peca_list(request):
    pecas = Peca.objects.all()

    if request.method == "POST":
        id = request.POST.get('id_del')
        Peca.objects.filter(id=id).delete()
        #deletePeca()
    return render(request, "web_aplication/pecas_list.html", locals())

def compra_list(request):
    compras = Compra.objects.all()

    if request.method == "POST":
        id = request.POST.get('id_del')
        Compra.objects.filter(id=id).delete()
        #deleteCompra(compra)
    return render(request, "web_aplication/compras_list.html", locals())
