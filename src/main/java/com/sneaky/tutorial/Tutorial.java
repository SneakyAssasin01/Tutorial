package com.sneaky.tutorial;

import com.sneaky.tutorial.registry.Modblocks;
import com.sneaky.tutorial.registry.Moditems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.lwjgl.system.CallbackI;

public class Tutorial implements ModInitializer {

    public static final String MOD_ID = "tut";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(Moditems.RUBY));

public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
        new Identifier(MOD_ID, "other"))
        .icon(() -> new ItemStack(Blocks.ENCHANTING_TABLE))
        .appendItems(stacks -> {
            stacks.add(new ItemStack(Modblocks.RUBY_BLOCK));
            stacks.add(new ItemStack(Moditems.RUBY));
            stacks.add(new ItemStack(Items.APPLE));
        })
        .build();


    @Override
    public void onInitialize() {
        Moditems.registerItems();
        Modblocks.registerBlocks();
    }
}
