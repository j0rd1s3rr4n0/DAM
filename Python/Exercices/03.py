
importe,descompte = int(input('Importe: ')),20
preudescomptat = importe*(descompte/100)
noupreu = importe-preudescomptat
print('Descompte: -'+str(descompte)+'%\nPreu: '+str(importe)+'€\nT\'estalvies: '+str(preudescomptat)+'€\nPreu Final: '+str(noupreu)+'€')