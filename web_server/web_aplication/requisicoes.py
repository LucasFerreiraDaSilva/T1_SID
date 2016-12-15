import json, requests
from .models import *

URL_WEB_SERVICE = 'http://192.168.1.100:8080/GerenciadorBancos-0.0.1-inicial/servicos/'

def putCliente(dic_cliente):
    r = requests.put(URL_WEB_SERVICE+'cadastrarcliente', data=dic_cliente)
    if r.status_code == requests.codes.ok:
        print("PUT to "+ URL_WEB_SERVICE+'cadastrarcliente' +" success! data = "+ str(dic_cliente))
    else:
        print("PUT to "+ URL_WEB_SERVICE+'cadastrarcliente' +" error! code = "+ r.status_code)

def putFabricante(dic_fabricante):
    r = requests.put(URL_WEB_SERVICE+'cadastrarfabricante', data=dic_fabricante)
    if r.status_code == requests.codes.ok:
        print("PUT to "+ URL_WEB_SERVICE+'cadastrarfabricante' +" success! data = "+ str(dic_fabricante))
    else:
        print("PUT to "+ URL_WEB_SERVICE+'cadastrarfabricante' +" error! code = "+ r.status_code)

def putPeca(dic_peca):
    r = requests.put(URL_WEB_SERVICE+'cadastrarpeca', data=dic_peca)
    if r.status_code == requests.codes.ok:
        print("PUT to "+ URL_WEB_SERVICE+'cadastrarpeca' +" success! data = "+ str(dic_peca))
    else:
        print("PUT to "+ URL_WEB_SERVICE+'cadastrarpeca' +" error! code = "+ r.status_code)

def putCliente(dic_compra):
    r = requests.put(URL_WEB_SERVICE+'cadastrarcompra', data=dic_compra)
    if r.status_code == requests.codes.ok:
        print("PUT to "+ URL_WEB_SERVICE+'cadastrarcompra' +" success! data = "+ str(dic_compra))
    else:
        print("PUT to "+ URL_WEB_SERVICE+'cadastrarcompra' +" error! code = "+ r.status_code)

# funcoes de delete

def deleteCliente(id):
    r = requests.delete(URL_WEB_SERVICE+'deletecliente/'+id)

def deleteFabricante(id):
    r = requests.put(URL_WEB_SERVICE+'deletefabricante/'+id)

def deletePeca(id):
    r = requests.put(URL_WEB_SERVICE+'deletepeca/'+id)

def deleteCompra(id):
    r = requests.put(URL_WEB_SERVICE+'deletecompra/'+id)

# Funcoes de sincronizacao

def sincFabricante():
    req = requests.get( URL_WEB_SERVICE+'listarfabricantes').json()

    print(req)

    for obj in req:
        try:
            fabricante = Fabricante.objects.get(pk=obj.get('idFabricante'))
        except Fabricante.DoesNotExist:
            fabricante = None

        if fabricante is None:
            nome = obj.get('nome')
            cnpj = obj.get('cnpj')
            c = Fabricante(nome=nome, cnpj=cnpj)
            c.save()

def sincCliente():
    req = requests.get( URL_WEB_SERVICE+'listarclientes').json()

    # tratamento para deixar no formato do json do trabalho
    #del r['meta']
    #req = r.get('objects')
    #######################################################
    print(req)

    for obj in req:
        try:
            cliente = Cliente.objects.get(pk=obj.get('idCliente'))
        except Cliente.DoesNotExist:
            cliente = None

        if cliente is None:
            nome = obj.get('nome')
            cpf = obj.get('cpf')
            c = Cliente(nome=nome, cpf=cpf)
            c.save()

def sincPecas():
    req = requests.get( URL_WEB_SERVICE+'listarpecas').json()

    print(req)

    for obj in req:

        try:
            pecas = Peca.objects.get(pk=obj.get('idPeca'))
        except Peca.DoesNotExist:
            pecas = None

        if pecas is None:
            descricao = obj.get('descricao')
            valor_unit  = obj.get('valorUnitario')
            id_fabricante = obj.get('idFabricante')
            fab = Fabricante.objects.get(pk=id_fabricante)
            p = Peca(descricao=descricao, valor_unit=valor_unit, fabricante=fab)
            p.save()

def sincCompras():
    req = requests.get( URL_WEB_SERVICE+'listarcompras').json()

    print(req)

    for obj in req:
        try:
            compras = Compra.objects.get(pk=obj.get('idCompra'))
        except Compra.DoesNotExist:
            compras = None

        if compras is None:
            quantidade = obj.get('quantidade')
            data = obj.get('data')
            id_cliente = obj.get('idCliente')
            id_peca = obj.get('idPeca')

            cliente = Cliente.objects.get(pk=id_cliente)
            peca = Peca.objects.get(pk=id_peca)
            c = Compra(quantidade=quantidade, data=data, cliente=cliente, peca=peca)
            c.save()

def sincAllModels():
    sincCliente()
    sincFabricante()
    sincPecas()
    sincCompras()
