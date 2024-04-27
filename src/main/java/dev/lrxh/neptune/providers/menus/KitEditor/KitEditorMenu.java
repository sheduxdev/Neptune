package dev.lrxh.neptune.providers.menus.KitEditor;

import dev.lrxh.neptune.Neptune;
import dev.lrxh.neptune.configs.impl.MenusLocale;
import dev.lrxh.neptune.kit.Kit;
import dev.lrxh.neptune.utils.menu.Button;
import dev.lrxh.neptune.utils.menu.Menu;
import dev.lrxh.neptune.utils.menu.filters.Filters;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class KitEditorMenu extends Menu {

    @Override
    public String getTitle(Player player) {
        return MenusLocale.KIT_EDITOR_SELECT_TITLE.getString();
    }

    @Override
    public int getSize() {
        return MenusLocale.KIT_EDITOR_SELECT_SIZE.getInt();
    }

    @Override
    public Filters getFilter() {
        return Filters.valueOf(MenusLocale.KIT_EDITOR_SELECT_FILTER.getString());
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();
        int i = MenusLocale.KIT_EDITOR_SELECT_STARTING_SLOT.getInt();
        for (Kit kit : Neptune.get().getKitManager().kits) {
            buttons.put(i++, new KitEditorSelectButton(kit));
        }
        return buttons;
    }
}
