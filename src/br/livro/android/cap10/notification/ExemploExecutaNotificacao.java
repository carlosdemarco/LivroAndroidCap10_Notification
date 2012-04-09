package br.livro.android.cap10.notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import br.livro.android.cap10.R;

/**
 * Activity que executa quando o usuário selecione a notificação na barra de status
 * 
 * Activity simples que apenas exibe uma mensagem na tela
 * 
 * Aqui é feito o cancelamento da notificação, para fechar a mesma depois de o usuário abrir
 * 
 * @author ricardo
 *
 */
public class ExemploExecutaNotificacao extends Activity {
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		// Cancela a notificação
		NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		// Para cancelar precisa utilizar o mesmo id que foi utilizado para criar
		nm.cancel(R.string.app_name);

		TextView text = new TextView(this);
		text.setText("Usuário selecionou a notificação. É possível executar algo agora.");
		setContentView(text);
	}
}
