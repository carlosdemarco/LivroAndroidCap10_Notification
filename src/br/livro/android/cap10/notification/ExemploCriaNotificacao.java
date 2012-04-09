package br.livro.android.cap10.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import br.livro.android.cap10.R;

/**
 * Exemplo de Activity que cria uma notificação
 * 
 * @author ricardo
 * 
 */
public class ExemploCriaNotificacao extends Activity {

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		TextView text = new TextView(this);
		text.setText("Uma notificação foi disparada.");
		setContentView(text);

		// Texto com a chamada para a notificação (barra de status)
		String tickerText = "Você recebeu uma mensagem";

		// Detalhes da mensagem, quem enviou e o texto
		CharSequence titulo = "Ricardo";
		CharSequence mensagem = "Exemplo de notificação";

		// Exibe a notificação para abrir a RecebeuMensagemActivity
		criarNotificacao(this, tickerText, titulo, mensagem, ExemploExecutaNotificacao.class);
	}

	// Exibe a notificação
	protected void criarNotificacao(Context context, CharSequence mensagemBarraStatus, CharSequence titulo, CharSequence mensagem, Class<?> activity) {

		// Recupera o serviço do NotificationManager
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		Notification n = new Notification(R.drawable.chat, mensagemBarraStatus, System.currentTimeMillis());

		// PendingIntent para executar a Activity se o usuário selecionar a
		// notificação
		PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this, activity), 0);

		// Informações
		n.setLatestEventInfo(this, titulo, mensagem, p);

		// Precisa de permissão: <uses-permission
		// android:name="android.permission.VIBRATE" />
		// espera 100ms e vibra por 250ms, depois espera por 100 ms e vibra por
		// 500ms.
		n.vibrate = new long[] { 100, 250, 100, 500 };

		// id (numero único) que identifica esta notificação
		nm.notify(R.string.app_name, n);
	}
}
